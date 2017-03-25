;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Python/Clojure encrypt/decrypt code for AES/ECB/PKCS5Padding 128/256 bits          ;;
;; Ischenko Vladyslav 07/09/2016                                                      ;;
;;                                                                                    ;;
;; Java Cryptography Extension (JCE) Unlimited Strength Jurisdiction Policy           ;;
;; http://www.oracle.com/technetwork/java/javase/downloads/jce-7-download-432124.html ;;
;;                                                                                    ;;
;; Copy local_policy.jar and US_export_policy.jar to the $JAVA_HOME/jre/lib/security  ;;
;; (Note: these jars will be already there so you have to overwrite them)             ;;
;;                                                                                    ;;
;; Ubuntu:                                                                            ;;
;; 1. Download and unzip                                                              ;;
;; 2. sudo cp -r UnlimitedJCEPolicy/* /usr/lib/jvm/java-8-oracle/jre/lib/security     ;;
;;                                                                                    ;;
;; AES/ECB/PKCS5Padding 128/256 bits                                                  ;;
;;                                                                                    ;;
;; 128bits == 16Bytes == 16 Chars.                                                    ;;
;; 256bits == 32Bytes == 32 Chars.                                                    ;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;


(import (java.security Key)
        (javax.crypto Cipher)
        (javax.crypto.spec SecretKeySpec)
        (org.apache.commons.codec.binary Base64))

(defn- to-bytes [s]
  (cond
    (string? s)     (.getBytes s "UTF-8")
    (sequential? s) (into-array Byte/TYPE (.getBytes s "UTF-8"))
    :else s))

(defn debase64 [s] (Base64/decodeBase64 (to-bytes s)))
(defn base64 [s] (Base64/encodeBase64String s))

(defn- ^Key secret-spec
  [^String s]
  (SecretKeySpec. (to-bytes s) "AES"))

(defn ^bytes encrypt
  [^String s ^String key]
  (let [cipher (doto (Cipher/getInstance "AES/ECB/PKCS5Padding")
                 (.init Cipher/ENCRYPT_MODE (secret-spec key)))]
    (.doFinal cipher (to-bytes s))))

(defn ^String decrypt
  [^bytes buf ^String key]
  (let [cipher (doto (Cipher/getInstance "AES/ECB/PKCS5Padding")
                 (.init Cipher/DECRYPT_MODE (secret-spec key)))]
    (String. (.doFinal cipher buf) "UTF-8")))

(defn encrypt->str [s key] (-> (encrypt s key) base64))
(defn decrypt->str [s key] (-> (decrypt (debase64 s) key)))

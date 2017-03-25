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

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Errors like:
;; javax.crypto.BadPaddingException: Given final block not properly padded
;; ClassCastException java.lang.String cannot be cast to [B  clojure.lang.Numbers.bytes (Numbers.java:1371)
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

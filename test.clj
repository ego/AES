(ns test
  (:require [clojure.test :as t]))

(def crypt-key = "12345678912345678912345678912345")

(def text1 "Алена Лазуткина")
(is (decrypt->str (encrypt->str text1 crypt-key) crypt-key) text1)

(def text2 "Vlad Ischenko")
(is (decrypt->str (encrypt->str text2 crypt-key) crypt-key) text2)

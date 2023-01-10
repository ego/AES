(ns test
  (:require [clojure.test :as t]))

(def crypt-key = "12345678912345678912345678912345")

(def text1 "John Doe")
(is (decrypt->str (encrypt->str text1 crypt-key) crypt-key) text1)

(def text2 "Martin Fowler")
(is (decrypt->str (encrypt->str text2 crypt-key) crypt-key) text2)

from aes_ecb_pkcs5padding_128_256 import encrypt, decrypt

text1 = "John Doe"
text2 = "Martin Fowler"

decrypt(encrypt(text1)) == text1
decrypt(encrypt(text2)) == text2

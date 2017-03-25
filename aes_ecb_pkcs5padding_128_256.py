#####################################################################
# Python encrypt/decrypt code for AES/ECB/PKCS5Padding 128/256 bits #
#                                                                   #
# 128bits == 16Bytes == 16 Chars.                                   #
# 256bits == 32Bytes == 32 Chars.                                   #
#####################################################################


import base64
from Crypto.Cipher import AES


CRYPT_KEY = '12345678912345678912345678912345'
_AES_CIPHER = AES.new(CRYPT_KEY)
_BLOCK_SIZE = _AES_CIPHER.block_size


def pad(s):
    len_pad = _BLOCK_SIZE - (len(s) % _BLOCK_SIZE)
    return s + (len_pad * chr(len_pad))


def unpad(s):
    return s[:-ord(s[-1])]


def encrypt(s):
    if not isinstance(s, basestring) or not s:
        return s
    pad_text = pad(s.encode('utf-8'))
    crypt_text = _AES_CIPHER.encrypt(pad_text)
    return base64.b64encode(crypt_text)


def decrypt(s):
    if not isinstance(s, basestring) or not s:
        return s
    try:
        crypt_text = base64.b64decode(s)
        pad_text = _AES_CIPHER.decrypt(crypt_text)
        text = unpad(pad_text).decode('utf-8')
    except (ValueError, TypeError, UnicodeEncodeError, UnicodeEncodeError):
        return s
    return text

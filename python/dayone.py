Python 3.3.0 (v3.3.0:bd8afb90ebf2, Sep 29 2012, 10:57:17) [MSC v.1600 64 bit (AMD64)] on win32
Type "copyright", "credits" or "license()" for more information.
>>> print( "hello" 0
       
SyntaxError: invalid syntax
>>> print( "hello" )
hello
>>> print( "heelooo your mom's puss smell like juice" )
heelooo your mom's puss smell like juice
>>> a = []
>>> a.append( "a" )
>>> a
['a']
>>> a.append( "b" )
>>> a
['a', 'b']
>>> a.append( "c" )
>>> a.append( 1 )
>>> a
['a', 'b', 'c', 1]
>>> a.append( "&" )
>>> 
>>> a
['a', 'b', 'c', 1, '&']
>>> str1 = "a"
>>> str2 = "b"
>>> str1 + str2
'ab'
>>> "1" + "2"
'12'
>>> 1 + 2
3
>>> str = "bob walks"
>>> str[0]
'b'
>>> str[0:2]
'bo'
>>> str[0:3]
'bob'
>>> str[-1]
's'
>>> str[-0]
'b'
>>> str[-1:-3]
''
>>> str[-1:3]
''
>>> str[1:-3]
'ob wa'
>>> str[3:-5]
' '
>>> str[2:-2]
'b wal'
>>> ["adfa",1, 2.5 ]
['adfa', 1, 2.5]
>>> ["adfa",1, 2.5 ][1,-1]
Traceback (most recent call last):
  File "<pyshell#31>", line 1, in <module>
    ["adfa",1, 2.5 ][1,-1]
TypeError: list indices must be integers, not tuple
>>> v = ["adfa",1, 2.5 ]
>>> v
['adfa', 1, 2.5]
>>> v[1]
1
>>> v[0:1]
['adfa']
>>> v = ["adfa",1, "2.boblocks" ]
>>> v[1:2]
[1]
>>> v[3]
Traceback (most recent call last):
  File "<pyshell#38>", line 1, in <module>
    v[3]
IndexError: list index out of range
>>> v[2]
'2.boblocks'
>>> 
>>> 52
51
48
29
54
13

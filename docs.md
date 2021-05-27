# Timer
Go to the 'Notes' folder, then run ``javac Timer.java`` and ``java Timer``
You can enter a specific length for your break and study sessions, or use the default, which is 10-50.

# Notes
Go to the 'Notes' folder, then run ``javac Main.java`` and ``java Main``

# Tasks
Go to the 'Tasks' folder, then run ``javac Main.java`` and ``java Main``

# Encryption

Encryption is _not_ supported on Microsoft Windows. Here are the instructions for how
to encrypt your notes or tasks using OS X and GNU/Linux;

## installing dendencies
1. GNU/Linux:


GPG is included by default on most GNU/Linux distributions, and so you have nothing to install.


2. OS X:


```brew install gnupg```

## performing file encryption
Navigate to the 'Encryption' folder. Be sure to edit the file paths so they match ones
on your system, or the program will not work. Run either ```Encryption.java``` or
```Decryption.java``` depending on which one you want to do. Keep in mind that the 
program waits 30 seconds before removing the encrypted or decrypted version of the 
text file.
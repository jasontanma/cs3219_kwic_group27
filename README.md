#  Introduction

The task given is to implement two KWIC (Key Word In Context) system with different architectural designs. A KWIC index is generated as the output which is a list of circularly shifted and alphabetized lines. The KWIC system implemented, regardless of the architectural designs, should allow input of K lines and generate the KWIC index of the lines inputted.

###  Installation

Clone repository from Github

### Instructions to run program

**Recommended**

Import project into IntelliJ IDEA and press 'Run'

**Alternatively**

Open a console in the root folder of the project

Run `cd out/production/kwic`

Run either `java com.kwic.adt.MasterControl` to test Abstract Data Types implementation

or `java com.kwic.pipeandfilter.Mastercontrol` to test Pipe and Filter implementation

### Additional notes
Compiled test cases can be found under the `test case` directory. Within each file, contains both lists of input lines and ignored words. Note that these test cases files are not meant to be used directly as inputs to the program, rather, users have to split up the input lines and ignored words into two separate files and pass them into the program accordingly.  

### CS3219 Group 27
Tan Mun Aw (A0108385B) and Leong Wei Ming (A0110674M)
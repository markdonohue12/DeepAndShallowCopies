
Assuming you are in the directory containing this README:

## To clean:
ant -buildfile src/build.xml clean

-----------------------------------------------------------------------
## To compile: 
ant -buildfile src/build.xml all

-----------------------------------------------------------------------
## To run by specifying arguments from command line 
## We will use this to run your code
ant -buildfile src/build.xml run -Darg0=FIRST -Darg1=SECOND

———————————————————————————————————

## To create tarball for submission
ant -buildfile src/build.xml tarzip or tar -zcvf firstName_secondName_assign_number.tar.gz firstName_secondName_assign_number

-----------------------------------------------------------------------

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating I will have to sign an
official form that I have cheated and that this form will be stored in
my official university record. I also understand that I will receive a
grade of 0 for the involved assignment for my first offense and that I
will receive a grade of F for the course for any additional
offense.”

[Date: Oct. 4, 2017]
Mark Donohue

-----------------------------------------------------------------------

Provide justification for Data Structures used in this assignment in
term of Big O complexity (time and/or space)

I used a Binary Search Tree in this assignment. The BST if good here because it's worst case is always O(n) for all operations: search, delete, and insert. As the input files to this program grow bigger and bigger, we will continue to have a complexity of O(n) as our worst case.

-----------------------------------------------------------------------

Provide list of citations (urls, etc.) from where you have taken code
(if any).

http://www.geeksforgeeks.org/binary-search-tree-set-1-search-and-insertion/
referenced information on this url when building my search method within TreeBuilder.java

http://pages.cs.wisc.edu/~hasti/cs302/examples/Parsing/parseString.html
referenced information on this page to learn more about file reading and good ways of parcing the file input to be used when creating nodes.

http://www.sanfoundry.com/java-program-implement-binary-search-tree/
referenced this page when figuring out the best way to read information from the input.txt file



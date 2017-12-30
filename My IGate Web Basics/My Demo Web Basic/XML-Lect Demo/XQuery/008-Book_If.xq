xquery version "1.0";
for $x in doc("books.xml")/bookstore/book
return if ($x/@category="CHILDREN")
then <child>{data($x/title)}</child>
else <adult>{data($x/title)}</adult>


(:
//Output
<adult>Everyday Italian</adult>
<child>Harry Potter</child>
<adult>XQuery Kick Start</adult>
<adult>Learning XML</adult>


XQuery Comparisons
In XQuery there are two ways of comparing values.

1. General comparisons: =, !=, <, <=, >, >=

2. Value comparisons: eq, ne, lt, le, gt, ge

The difference between the two comparison methods are shown below.

The following expression returns true if any q attributes have a value greater than 10:

$bookstore//book/@q > 10 

The following expression returns true if there is only one q attribute returned by the expression, and its value is greater than 10. If more than one q is returned, an error occurs:

$bookstore//book/@q gt 10 




:)
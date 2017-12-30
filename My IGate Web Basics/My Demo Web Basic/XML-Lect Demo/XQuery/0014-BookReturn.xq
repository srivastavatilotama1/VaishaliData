xquery version "1.0";
for $x in doc("books.xml")/bookstore/book
return $x/title

(:

The return Clause
The return clause specifies what is to be returned.

<title lang="en">Everyday Italian</title>
<title lang="en">Harry Potter</title>
<title lang="en">XQuery Kick Start</title>
<title lang="en">Learning XML</title>
:)
xquery version "1.0";
for $x in doc("books.xml")/bookstore/book
order by $x/@category, $x/title
return $x/title


(:
The order by Clause
The order by clause is used to specify the sort order of the result. Here we want to order the result by category and title:


<title lang="en">Harry Potter</title>
<title lang="en">Everyday Italian</title>
<title lang="en">Learning XML</title>
<title lang="en">XQuery Kick Start</title>

:)
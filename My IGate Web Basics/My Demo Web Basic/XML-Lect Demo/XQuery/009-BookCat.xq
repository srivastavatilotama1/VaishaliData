xquery version "1.0";
<html>
<body>

<h1>Bookstore</h1>

<ul>
{
for $x in doc("books.xml")/bookstore/book
order by $x/title
return <li class="{data($x/@category)}">{data($x/title)}</li>
}
</ul>

</body>
</html>


(:

See  and Run First BookCat1.xq
 Now we want to use the category attribute as a class attribute in the HTML list:




//Output
<html>
	<body>
		<h1>Bookstore</h1>
			<ul>
					<li class="COOKING">Everyday Italian</li>
					<li class="CHILDREN">Harry Potter</li>
					<li class="WEB">Learning XML</li>
					<li class="WEB">XQuery Kick Start</li>
			</ul>
	</body>
</html>





:)
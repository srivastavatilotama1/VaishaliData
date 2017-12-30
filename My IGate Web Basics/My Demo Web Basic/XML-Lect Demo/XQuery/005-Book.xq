xquery version "1.0";
<ul>
{
for $x in doc("books.xml")/bookstore/book/title
order by $x
return <li>{$x}</li>
}
</ul>


(:
<ul>
			<li>
				<title lang="en">Everyday Italian	</title>
			</li>
			<li>
				<title lang="en">Harry Potter</title>
			</li>
			<li><title lang="en">Learning XML</title></li>
			<li><title lang="en">XQuery Kick Start</title></li>
</ul>



:)
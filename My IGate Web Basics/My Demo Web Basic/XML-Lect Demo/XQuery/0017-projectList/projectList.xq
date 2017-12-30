
for $x in doc( "C:\XML\projectList.xml" )/projectList/project
    order by $x/projectName
    return $x/projectName

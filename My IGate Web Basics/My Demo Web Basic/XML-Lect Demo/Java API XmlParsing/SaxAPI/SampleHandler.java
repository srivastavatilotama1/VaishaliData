// SampleHandler.java

//package com.cognizant.samples.xml;

import org.xml.sax.Attributes;

import org.xml.sax.helpers.DefaultHandler;

public class SampleHandler extends DefaultHandler 
{

    public void startDocument() {

        System.out.println( "Start document" );
    }

    public void endDocument() 
    {

        System.out.println( "End document" );
    }

    public void startElement( String uri, String name, String qName, Attributes atts ) 
    {

        if ( "".equals( uri ) ) 
        {
        	  System.out.println( " start element: uri:"  + uri        + " name:"  + name +"  qname :"+qName +"   Attributes :"+atts);
        } 
        else 
        {
            System.out.println( "Else .......... start element: uri:"  + uri        + " name:"  + name +"  qname "+qName +"   Attributes :"+atts);
        }
    }

    public void endElement( String uri, String name, String qName ) 
    {

        if ( "".equals( uri ) ) 
        {
            System.out.println( "end element: name:" + qName );
        } else
        {
            System.out.println( "end element: uri: " + uri
                  + " name: "  + name );
        }
    }

    public void characters( char[] ca, int start, int length ) 
    {

        System.out.println( "Characters event fired" );

        for ( int i = start; i < start + length; i++ ) 
        {

            switch ( ca[i] ) 
            {

                case '\\': System.out.print( "\\\\" ); break;
                case '"' : System.out.print( "\\\"" ); break;
                case '\n': System.out.print( "\\n" ); break;
                case '\r': System.out.print( "\\r" ); break;
                case '\t': System.out.print( "\\t" ); break;
                default: System.out.print( ca[i] );break;
            }
        }

        System.out.println( "\nEnd of characters method" );
    }
}

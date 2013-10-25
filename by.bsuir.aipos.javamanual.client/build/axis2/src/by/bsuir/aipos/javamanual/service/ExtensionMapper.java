
/**
 * ExtensionMapper.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.3  Built on : Aug 10, 2007 (04:45:58 LKT)
 */

            package by.bsuir.aipos.javamanual.service;
            /**
            *  ExtensionMapper class
            */
        
        public  class ExtensionMapper{

          public static java.lang.Object getTypeObject(java.lang.String namespaceURI,
                                                       java.lang.String typeName,
                                                       javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{

              
                  if (
                  "http://io.java/xsd".equals(namespaceURI) &&
                  "IOException".equals(typeName)){
                   
                            return  java.io.xsd.IOException.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://sax.xml.org/xsd".equals(namespaceURI) &&
                  "SAXException".equals(typeName)){
                   
                            return  org.xml.sax.xsd.SAXException.Factory.parse(reader);
                        

                  }

              
             throw new org.apache.axis2.databinding.ADBException("Unsupported type " + namespaceURI + " " + typeName);
          }

        }
    
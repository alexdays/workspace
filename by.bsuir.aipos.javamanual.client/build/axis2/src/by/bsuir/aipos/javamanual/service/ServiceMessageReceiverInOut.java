
/**
 * ServiceMessageReceiverInOut.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.3  Built on : Aug 10, 2007 (04:45:47 LKT)
 */
        package by.bsuir.aipos.javamanual.service;

        /**
        *  ServiceMessageReceiverInOut message receiver
        */

        public class ServiceMessageReceiverInOut extends org.apache.axis2.receivers.AbstractInOutSyncMessageReceiver{


        public void invokeBusinessLogic(org.apache.axis2.context.MessageContext msgContext, org.apache.axis2.context.MessageContext newMsgContext)
        throws org.apache.axis2.AxisFault{

        try {

        // get the implementation class for the Web Service
        Object obj = getTheImplementationObject(msgContext);

        ServiceSkeletonInterface skel = (ServiceSkeletonInterface)obj;
        //Out Envelop
        org.apache.axiom.soap.SOAPEnvelope envelope = null;
        //Find the axisOperation that has been set by the Dispatch phase.
        org.apache.axis2.description.AxisOperation op = msgContext.getOperationContext().getAxisOperation();
        if (op == null) {
        throw new org.apache.axis2.AxisFault("Operation is not located, if this is doclit style the SOAP-ACTION should specified via the SOAP Action to use the RawXMLProvider");
        }

        java.lang.String methodName;
        if((op.getName() != null) && ((methodName = org.apache.axis2.util.JavaUtils.xmlNameToJava(op.getName().getLocalPart())) != null)){

        

            if("eraseConcept".equals(methodName)){
                
                by.bsuir.aipos.javamanual.service.EraseConcept wrappedParam =
                                                             (by.bsuir.aipos.javamanual.service.EraseConcept)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    by.bsuir.aipos.javamanual.service.EraseConcept.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               
                                                         skel.eraseConcept(wrappedParam)
                                                    ;
                                            
                                        envelope = getSOAPFactory(msgContext).getDefaultEnvelope();
                                    } else 

            if("addConcept".equals(methodName)){
                
                by.bsuir.aipos.javamanual.service.AddConcept wrappedParam =
                                                             (by.bsuir.aipos.javamanual.service.AddConcept)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    by.bsuir.aipos.javamanual.service.AddConcept.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               
                                                         skel.addConcept(wrappedParam)
                                                    ;
                                            
                                        envelope = getSOAPFactory(msgContext).getDefaultEnvelope();
                                    } else 

            if("getAllConcepts".equals(methodName)){
                
                by.bsuir.aipos.javamanual.service.GetAllConceptsResponse getAllConceptsResponse18 = null;
	                        by.bsuir.aipos.javamanual.service.GetAllConcepts wrappedParam =
                                                             (by.bsuir.aipos.javamanual.service.GetAllConcepts)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    by.bsuir.aipos.javamanual.service.GetAllConcepts.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               getAllConceptsResponse18 =
                                                   
                                                   
                                                         skel.getAllConcepts(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), getAllConceptsResponse18, false);
                                    } else 

            if("getConceptContent".equals(methodName)){
                
                by.bsuir.aipos.javamanual.service.GetConceptContentResponse getConceptContentResponse20 = null;
	                        by.bsuir.aipos.javamanual.service.GetConceptContent wrappedParam =
                                                             (by.bsuir.aipos.javamanual.service.GetConceptContent)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    by.bsuir.aipos.javamanual.service.GetConceptContent.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               getConceptContentResponse20 =
                                                   
                                                   
                                                         skel.getConceptContent(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), getConceptContentResponse20, false);
                                    } else 

            if("changeConcept".equals(methodName)){
                
                by.bsuir.aipos.javamanual.service.ChangeConcept wrappedParam =
                                                             (by.bsuir.aipos.javamanual.service.ChangeConcept)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    by.bsuir.aipos.javamanual.service.ChangeConcept.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               
                                                         skel.changeConcept(wrappedParam)
                                                    ;
                                            
                                        envelope = getSOAPFactory(msgContext).getDefaultEnvelope();
                                    
            } else {
              throw new java.lang.RuntimeException("method not found");
            }
        

        newMsgContext.setEnvelope(envelope);
        }
        } catch (ServiceIOExceptionException0 e) {

            msgContext.setProperty(org.apache.axis2.Constants.FAULT_NAME,"ServiceIOException");
            org.apache.axis2.AxisFault f = createAxisFault(e);
            if (e.getFaultMessage() != null){
                f.setDetail(toOM(e.getFaultMessage(),false));
            }
            throw f;
            }
         catch (ServiceSAXExceptionException1 e) {

            msgContext.setProperty(org.apache.axis2.Constants.FAULT_NAME,"ServiceSAXException");
            org.apache.axis2.AxisFault f = createAxisFault(e);
            if (e.getFaultMessage() != null){
                f.setDetail(toOM(e.getFaultMessage(),false));
            }
            throw f;
            }
         catch (ServiceTransformerExceptionException2 e) {

            msgContext.setProperty(org.apache.axis2.Constants.FAULT_NAME,"ServiceTransformerException");
            org.apache.axis2.AxisFault f = createAxisFault(e);
            if (e.getFaultMessage() != null){
                f.setDetail(toOM(e.getFaultMessage(),false));
            }
            throw f;
            }
         catch (ServiceParserConfigurationExceptionException3 e) {

            msgContext.setProperty(org.apache.axis2.Constants.FAULT_NAME,"ServiceParserConfigurationException");
            org.apache.axis2.AxisFault f = createAxisFault(e);
            if (e.getFaultMessage() != null){
                f.setDetail(toOM(e.getFaultMessage(),false));
            }
            throw f;
            }
        
        catch (java.lang.Exception e) {
        throw org.apache.axis2.AxisFault.makeFault(e);
        }
        }
        
        //
            private  org.apache.axiom.om.OMElement  toOM(by.bsuir.aipos.javamanual.service.AddConcept param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(by.bsuir.aipos.javamanual.service.AddConcept.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(by.bsuir.aipos.javamanual.service.ServiceIOException param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(by.bsuir.aipos.javamanual.service.ServiceIOException.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(by.bsuir.aipos.javamanual.service.ServiceSAXException param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(by.bsuir.aipos.javamanual.service.ServiceSAXException.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(by.bsuir.aipos.javamanual.service.ServiceTransformerException param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(by.bsuir.aipos.javamanual.service.ServiceTransformerException.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(by.bsuir.aipos.javamanual.service.ServiceParserConfigurationException param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(by.bsuir.aipos.javamanual.service.ServiceParserConfigurationException.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(by.bsuir.aipos.javamanual.service.ChangeConcept param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(by.bsuir.aipos.javamanual.service.ChangeConcept.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(by.bsuir.aipos.javamanual.service.GetAllConcepts param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(by.bsuir.aipos.javamanual.service.GetAllConcepts.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(by.bsuir.aipos.javamanual.service.GetAllConceptsResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(by.bsuir.aipos.javamanual.service.GetAllConceptsResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(by.bsuir.aipos.javamanual.service.GetConceptContent param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(by.bsuir.aipos.javamanual.service.GetConceptContent.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(by.bsuir.aipos.javamanual.service.GetConceptContentResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(by.bsuir.aipos.javamanual.service.GetConceptContentResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(by.bsuir.aipos.javamanual.service.EraseConcept param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(by.bsuir.aipos.javamanual.service.EraseConcept.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, by.bsuir.aipos.javamanual.service.GetAllConceptsResponse param, boolean optimizeContent)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(by.bsuir.aipos.javamanual.service.GetAllConceptsResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, by.bsuir.aipos.javamanual.service.GetConceptContentResponse param, boolean optimizeContent)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(by.bsuir.aipos.javamanual.service.GetConceptContentResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    


        /**
        *  get the default envelope
        */
        private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory){
        return factory.getDefaultEnvelope();
        }


        private  java.lang.Object fromOM(
        org.apache.axiom.om.OMElement param,
        java.lang.Class type,
        java.util.Map extraNamespaces) throws org.apache.axis2.AxisFault{

        try {
        
                if (by.bsuir.aipos.javamanual.service.AddConcept.class.equals(type)){
                
                           return by.bsuir.aipos.javamanual.service.AddConcept.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (by.bsuir.aipos.javamanual.service.ServiceIOException.class.equals(type)){
                
                           return by.bsuir.aipos.javamanual.service.ServiceIOException.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (by.bsuir.aipos.javamanual.service.ServiceSAXException.class.equals(type)){
                
                           return by.bsuir.aipos.javamanual.service.ServiceSAXException.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (by.bsuir.aipos.javamanual.service.ServiceTransformerException.class.equals(type)){
                
                           return by.bsuir.aipos.javamanual.service.ServiceTransformerException.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (by.bsuir.aipos.javamanual.service.ServiceParserConfigurationException.class.equals(type)){
                
                           return by.bsuir.aipos.javamanual.service.ServiceParserConfigurationException.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (by.bsuir.aipos.javamanual.service.ChangeConcept.class.equals(type)){
                
                           return by.bsuir.aipos.javamanual.service.ChangeConcept.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (by.bsuir.aipos.javamanual.service.ServiceIOException.class.equals(type)){
                
                           return by.bsuir.aipos.javamanual.service.ServiceIOException.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (by.bsuir.aipos.javamanual.service.ServiceSAXException.class.equals(type)){
                
                           return by.bsuir.aipos.javamanual.service.ServiceSAXException.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (by.bsuir.aipos.javamanual.service.ServiceTransformerException.class.equals(type)){
                
                           return by.bsuir.aipos.javamanual.service.ServiceTransformerException.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (by.bsuir.aipos.javamanual.service.ServiceParserConfigurationException.class.equals(type)){
                
                           return by.bsuir.aipos.javamanual.service.ServiceParserConfigurationException.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (by.bsuir.aipos.javamanual.service.GetAllConcepts.class.equals(type)){
                
                           return by.bsuir.aipos.javamanual.service.GetAllConcepts.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (by.bsuir.aipos.javamanual.service.GetAllConceptsResponse.class.equals(type)){
                
                           return by.bsuir.aipos.javamanual.service.GetAllConceptsResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (by.bsuir.aipos.javamanual.service.ServiceIOException.class.equals(type)){
                
                           return by.bsuir.aipos.javamanual.service.ServiceIOException.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (by.bsuir.aipos.javamanual.service.ServiceSAXException.class.equals(type)){
                
                           return by.bsuir.aipos.javamanual.service.ServiceSAXException.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (by.bsuir.aipos.javamanual.service.ServiceParserConfigurationException.class.equals(type)){
                
                           return by.bsuir.aipos.javamanual.service.ServiceParserConfigurationException.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (by.bsuir.aipos.javamanual.service.GetConceptContent.class.equals(type)){
                
                           return by.bsuir.aipos.javamanual.service.GetConceptContent.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (by.bsuir.aipos.javamanual.service.GetConceptContentResponse.class.equals(type)){
                
                           return by.bsuir.aipos.javamanual.service.GetConceptContentResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (by.bsuir.aipos.javamanual.service.ServiceIOException.class.equals(type)){
                
                           return by.bsuir.aipos.javamanual.service.ServiceIOException.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (by.bsuir.aipos.javamanual.service.ServiceSAXException.class.equals(type)){
                
                           return by.bsuir.aipos.javamanual.service.ServiceSAXException.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (by.bsuir.aipos.javamanual.service.ServiceParserConfigurationException.class.equals(type)){
                
                           return by.bsuir.aipos.javamanual.service.ServiceParserConfigurationException.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (by.bsuir.aipos.javamanual.service.EraseConcept.class.equals(type)){
                
                           return by.bsuir.aipos.javamanual.service.EraseConcept.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (by.bsuir.aipos.javamanual.service.ServiceIOException.class.equals(type)){
                
                           return by.bsuir.aipos.javamanual.service.ServiceIOException.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (by.bsuir.aipos.javamanual.service.ServiceSAXException.class.equals(type)){
                
                           return by.bsuir.aipos.javamanual.service.ServiceSAXException.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (by.bsuir.aipos.javamanual.service.ServiceTransformerException.class.equals(type)){
                
                           return by.bsuir.aipos.javamanual.service.ServiceTransformerException.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (by.bsuir.aipos.javamanual.service.ServiceParserConfigurationException.class.equals(type)){
                
                           return by.bsuir.aipos.javamanual.service.ServiceParserConfigurationException.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
        } catch (java.lang.Exception e) {
        throw org.apache.axis2.AxisFault.makeFault(e);
        }
           return null;
        }



    

        /**
        *  A utility method that copies the namepaces from the SOAPEnvelope
        */
        private java.util.Map getEnvelopeNamespaces(org.apache.axiom.soap.SOAPEnvelope env){
        java.util.Map returnMap = new java.util.HashMap();
        java.util.Iterator namespaceIterator = env.getAllDeclaredNamespaces();
        while (namespaceIterator.hasNext()) {
        org.apache.axiom.om.OMNamespace ns = (org.apache.axiom.om.OMNamespace) namespaceIterator.next();
        returnMap.put(ns.getPrefix(),ns.getNamespaceURI());
        }
        return returnMap;
        }

        private org.apache.axis2.AxisFault createAxisFault(java.lang.Exception e) {
        org.apache.axis2.AxisFault f;
        Throwable cause = e.getCause();
        if (cause != null) {
            f = new org.apache.axis2.AxisFault(e.getMessage(), cause);
        } else {
            f = new org.apache.axis2.AxisFault(e.getMessage());
        }

        return f;
    }

        }//end of class
    
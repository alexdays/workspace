
/**
 * ServiceCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package service;

    /**
     *  ServiceCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class ServiceCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public ServiceCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public ServiceCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for changeConcept method
            * override this method for handling normal response from changeConcept operation
            */
           public void receiveResultchangeConcept(
                    ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from changeConcept operation
           */
            public void receiveErrorchangeConcept(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getAllConcepts method
            * override this method for handling normal response from getAllConcepts operation
            */
           public void receiveResultgetAllConcepts(
                    service.ServiceStub.GetAllConceptsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getAllConcepts operation
           */
            public void receiveErrorgetAllConcepts(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getConceptContent method
            * override this method for handling normal response from getConceptContent operation
            */
           public void receiveResultgetConceptContent(
                    service.ServiceStub.GetConceptContentResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getConceptContent operation
           */
            public void receiveErrorgetConceptContent(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for addConcept method
            * override this method for handling normal response from addConcept operation
            */
           public void receiveResultaddConcept(
                    ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from addConcept operation
           */
            public void receiveErroraddConcept(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for eraseConcept method
            * override this method for handling normal response from eraseConcept operation
            */
           public void receiveResulteraseConcept(
                    ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from eraseConcept operation
           */
            public void receiveErroreraseConcept(java.lang.Exception e) {
            }
                


    }
    
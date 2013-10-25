
/**
 * ServiceSkeletonInterface.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.3  Built on : Aug 10, 2007 (04:45:47 LKT)
 */
    package by.bsuir.aipos.javamanual.service;
    /**
     *  ServiceSkeletonInterface java skeleton interface for the axisService
     */
    public interface ServiceSkeletonInterface {
     
         
        /**
         * Auto generated method signature
         
                                    * @param eraseConcept
         */

        
                public void eraseConcept
                (
                  by.bsuir.aipos.javamanual.service.EraseConcept eraseConcept
                 )
            throws ServiceIOExceptionException0,ServiceSAXExceptionException1,ServiceTransformerExceptionException2,ServiceParserConfigurationExceptionException3;
        
         
        /**
         * Auto generated method signature
         
                                    * @param addConcept
         */

        
                public void addConcept
                (
                  by.bsuir.aipos.javamanual.service.AddConcept addConcept
                 )
            throws ServiceIOExceptionException0,ServiceSAXExceptionException1,ServiceTransformerExceptionException2,ServiceParserConfigurationExceptionException3;
        
         
        /**
         * Auto generated method signature
         
                                    * @param getAllConcepts
         */

        
                public by.bsuir.aipos.javamanual.service.GetAllConceptsResponse getAllConcepts
                (
                  by.bsuir.aipos.javamanual.service.GetAllConcepts getAllConcepts
                 )
            throws ServiceIOExceptionException0,ServiceSAXExceptionException1,ServiceParserConfigurationExceptionException3;
        
         
        /**
         * Auto generated method signature
         
                                    * @param getConceptContent
         */

        
                public by.bsuir.aipos.javamanual.service.GetConceptContentResponse getConceptContent
                (
                  by.bsuir.aipos.javamanual.service.GetConceptContent getConceptContent
                 )
            throws ServiceIOExceptionException0,ServiceSAXExceptionException1,ServiceParserConfigurationExceptionException3;
        
         
        /**
         * Auto generated method signature
         
                                    * @param changeConcept
         */

        
                public void changeConcept
                (
                  by.bsuir.aipos.javamanual.service.ChangeConcept changeConcept
                 )
            throws ServiceIOExceptionException0,ServiceSAXExceptionException1,ServiceTransformerExceptionException2,ServiceParserConfigurationExceptionException3;
        
         }
    
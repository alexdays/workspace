/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package operations;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Александр
 */
@Local
public interface OperationBeanLocal {
    List<String> getAllConcepts();

    void addConcept(String name, String content);

    void changeConcept(String name, String content);

    void eraseConcept(String name);

    String getConceptContent(String name);

    void init();
}


package by.bsuir.ppvis.utls;

import java.util.Locale;
import java.util.ResourceBundle;

public enum Namespace {
    FILE("file"),
    EDIT("edit"),
    ABOUT("about"),
    NEW("new"),
    OPEN("open"),
    SAVE("save"),
    SAVEAS("saveas"),
    EXIT("exit"),
    ADD("add"),
    FIND("find"),
    ERASE("erase"),
    STUDENTFIO("studentfio"),
    PARENTFIO("parentfio"),
    WORKINGADDRESS("workingaddress"),
    PARENTPOST("parentpost"),
    PARENTEXPERIENCE("parentexperience"),
    INPUTDIALOG("inputdialog"),
    FINDDIALOG("finddialog"),
    ERASEDIALOG("erasedialog"),
    FIELDSTUDFIO("studfio"),
    FIELDPARENTFIO("parentfio"),
    FIELDWORKADDR("workaddr"),
    FIELDPARENTPOST("parentpost"),
    FIELDPARENTEXPER("parentexper"),
    OK("ok"),
    CANCEL("cancel");

    private String label;
    private Namespace(String label){
        this.label = label;
    }

    public String getLabel(String lang){
        ResourceBundle bundle = ResourceBundle.getBundle(lang, Locale.getDefault());
        return bundle.getString(label);
    }

}

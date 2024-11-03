package com.example.rospl;


import java.util.List;
 
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document; 

@Document(collection = "opportunities")
public class OppModel {
 

    @Id
    private String id;
    private String title;
    private List<String> Criteria;
    private String Category;
    private String field;
    private String l_date;
    private String s_date ;
    private String providerId; // Link to the provider
    private String org_name; // provider organisation

    // Getters and Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String Category) {
        this.Category = Category;
    }

    public void setfield(String field) {
        this.field = field;
    }

    public String getfield() {
        return field;
    }

    public void setOrgname(String org_name) {
        this.org_name = org_name;
    }

    public String getOrgname() {
        return org_name;
    }

    public String getProviderId() {
        return providerId;
    }

    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }

    public String getl_date() {
        return l_date;
    }

    public void setl_date(String l_date) {
        this.l_date = l_date;
    }

    public String getStartd() {
        return s_date;
    }

    public void setStartd(String s_date) {
        this.s_date = s_date;
    }

    public List<String> getCriteria() {
        return Criteria;
    }

    public void setCriteria(List<String> Criteria) {
        this.Criteria = Criteria;
    }
}


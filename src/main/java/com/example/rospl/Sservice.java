package com.example.rospl;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


@Service
public class Sservice {
    @Autowired
    private Repository repository;

    @Autowired
    private Repostud repostud;

    @Autowired
    private Repopro repopro;

    @Autowired
    private RepoOpp repoOpp;

    public OppModel saveOpportunity(OppModel opportunity) {
        return repoOpp.save(opportunity);
    }

    public List<OppModel> getOpportunitiesByProvider(String providerId) {
        return repoOpp.findByProviderId(providerId);
    }

    public List<OppModel> getproModels(String providerId) {
        return repoOpp.findByProviderId(providerId);
    }

    public Modell saveModel(MultipartFile adhar, MultipartFile marksheet, MultipartFile income, MultipartFile college_id, 
    String name, String contact, String email, String course, String oppId, String studid ) throws IOException {
        Modell model = new Modell();
        model.setName(name);
        model.setAdhar(adhar.getBytes());
        model.setCourse(course);
        model.setMark(marksheet.getBytes());
        model.setEmail(email);
        model.setIncome(income.getBytes());
        model.setContact(contact);
        model.setCollege(college_id.getBytes());
        model.setopId(oppId);
        model.setstudid(studid);
        return repository.save(model);
    }

    public Modell getFile(String id) {
        return repository.findById(id).orElse(null);
    }

    public byte[] getCollege(String id) {
        return repository.findById(id)
                .map(Modell::getCollege)
                .orElse(null); // or return Optional.empty() if you prefer
    }

    public byte[] getAdhar(String id) {
        return repository.findById(id)
                .map(Modell::getAdhar)
                .orElse(null); // or return Optional.empty() if you prefer
    }

    public byte[] getIncome(String id) {
        return repository.findById(id)
                .map(Modell::getIncome)
                .orElse(null); // or return Optional.empty() if you prefer
    }

    public byte[] getMark(String id) {
        return repository.findById(id)
                .map(Modell::getMark)
                .orElse(null); // or return Optional.empty() if you prefer
    }

    public List<ModelProjection> getAllModels(String opp) {
        return repository.findByoppId(opp);
    }

    public List<OppModel> getAppliOfStud(String studid) {
        List<ModelProjection> applications = repository.findBystudid(studid);
        List<String> opportunityIds = applications.stream()
                .map(ModelProjection::getopId)
                .toList();
        return repoOpp.findByIdIn(opportunityIds);
    }

    // public List<OppModel> getOppOfStud(List<String> oppIds) {
    //     // return repository.findByoppId(studid);
    //     return repoOpp.findByIdIn(oppIds);
    // }

    public List<OppModel> getModels() {
        return repoOpp.findAll();
    }

    public Optional<OppModel> getopp(String id){
        return repoOpp.findById(id);
    }

    public Student saveStud(Student model) {
        return repostud.save(model);
    }

    public Student registerUser(String username, String password) {
        Student model = new Student();
        System.out.println(username+" "+password);
        model.setName(username);
        model.setpass(password); // Hashing the password
        return repostud.save(model);
    }

    public Optional<Student> authenticateUser(String username, String password) {
        Optional<Student> user = repostud.findByUsername(username);
        if (user.isPresent() && password.equals(user.get().getpass())) {
            return user; // User authenticated
        }
        return Optional.empty(); // Authentication failed
    }

    

    public ProModel register(String username, String org, String info,String email,String password) {
        ProModel model = new ProModel();
        System.out.println(username+" "+password);
        model.setName(username);
        model.setpass(password); 
        model.setorg(org);
        model.setinfo(info); 
        model.setmail(email); 
        return repopro.save(model);
    }

    public Optional<ProModel> authenticate(String username, String password) {
        Optional<ProModel> user = repopro.findByUsername(username);
        if (user.isPresent() && password.equals(user.get().getpass())) {
            return user; // User authenticated
        }
        return Optional.empty(); // Authentication failed
    }
}
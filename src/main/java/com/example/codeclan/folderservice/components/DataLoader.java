package com.example.codeclan.folderservice.components;

import com.example.codeclan.folderservice.models.File;
import com.example.codeclan.folderservice.models.Folder;
import com.example.codeclan.folderservice.models.User;
import com.example.codeclan.folderservice.repositories.FileRepository;
import com.example.codeclan.folderservice.repositories.FolderRepository;
import com.example.codeclan.folderservice.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    private FileRepository fileRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FolderRepository folderRepository;

    public void run(ApplicationArguments args){

        fileRepository.deleteAll();
        userRepository.deleteAll();
        folderRepository.deleteAll();

        File taxreturn = new File("tax_return", ".doc", 20);
        fileRepository.save(taxreturn);

        File petinsurance = new File("pet_insurance", ".pdf", 80);
        fileRepository.save(petinsurance);

        File certificate = new File("certificate", ".pdf", 10);
        fileRepository.save(certificate);

        File accounts = new File("accounts", ".csv", 50);
        fileRepository.save(accounts);

        User sandara = new User("Sandara");
        userRepository.save(sandara);

        User bom = new User("Bom");
        userRepository.save(bom);

        User minzy = new User("Minzy");
        userRepository.save(minzy);

        User chaerin = new User("Chaerin");
        userRepository.save(chaerin);

        Folder insurance = new Folder("Insurance", sandara);
        folderRepository.save(insurance);

        Folder clinusurance = new Folder("Insurance", chaerin);
        folderRepository.save(clinusurance);

        Folder certificatesfolder = new Folder("certificates", chaerin);
        folderRepository.save(certificatesfolder);

        Folder accountsfolder = new Folder("Accounts", minzy);
        folderRepository.save(accountsfolder);

        accountsfolder.addFile(accounts);
        accountsfolder.addFile(taxreturn);
        folderRepository.save(accountsfolder);

        clinusurance.addFile(petinsurance);
        folderRepository.save(clinusurance);

        certificate.addToFolder(certificatesfolder);
        fileRepository.save(certificate);

    }
}

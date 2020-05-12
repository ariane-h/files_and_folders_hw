package com.example.codeclan.folderservice;

import com.example.codeclan.folderservice.models.File;
import com.example.codeclan.folderservice.models.Folder;
import com.example.codeclan.folderservice.models.User;
import com.example.codeclan.folderservice.repositories.FileRepository;
import com.example.codeclan.folderservice.repositories.FolderRepository;
import com.example.codeclan.folderservice.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FolderserviceApplicationTests {

	@Autowired
	UserRepository userRepository;

	@Autowired
	FolderRepository folderRepository;

	@Autowired
	FileRepository fileRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void canCreateAndSaveUsersFoldersFiles(){
		User sandara = new User("Sandara");
		userRepository.save(sandara);

		Folder folder = new Folder("Docs", sandara);
		folderRepository.save(folder);

		File file = new File("insurance", ".txt", 20);
		fileRepository.save(file);

		folder.addFile(file);
		folderRepository.save(folder);
	}


}

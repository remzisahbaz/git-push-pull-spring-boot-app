package com.remzisahbaz.gitpushpullspringbootapp.service;



import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.PullResult;
import org.eclipse.jgit.api.errors.GitAPIException;

import java.io.File;
import java.io.IOException;

public class GitService {
    String firstRepoPath = "/path/to/first/repository";
    String secondRepoPath = "/path/to/second/repository";

    public String  git() {

            try {
                pullChanges(firstRepoPath);
                pushChanges(secondRepoPath);
                System.out.println("Pull and push completed successfully.");

                // Wait for a certain period before the next iteration
                Thread.sleep(60000); // 1 minute (adjust as needed)
            } catch (IOException | GitAPIException | InterruptedException e) {
                e.printStackTrace();
                // Handle exceptions appropriately
                // For example, you may want to retry after a certain interval
            }

        return null;
    }

    private  void pullChanges(String repoPath) throws IOException, GitAPIException {
        Git git = Git.open(new File(repoPath));
        PullResult pullResult = git.pull().call();
        System.out.println("Pull from the repository completed: " + pullResult.isSuccessful());
    }

    private  void pushChanges(String repoPath) throws IOException, GitAPIException {
        Git git = Git.open(new File(repoPath));
        git.add().addFilepattern(".").call();
        git.commit().setMessage("Changes").call();
        git.push().call();
        System.out.println("Push to the repository completed successfully.");
    }
}

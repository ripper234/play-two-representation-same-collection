import models.Company;
import models.Person;
import models.Position;
import models.Project;
import play.Play;
import play.jobs.Job;
import play.jobs.OnApplicationStart;

import java.util.ArrayList;

@OnApplicationStart
public class Bootstrap extends Job {
    public Bootstrap() {
    }

    public void doJob() throws Exception {
        if (Play.runingInTestMode()) {
            return;
        }

        // Check if the database is empty
        if (Project.count() != 0) {
            return;
        }

        // Test
        Company facebook = new Company();
        facebook.name = "Facebook";
        facebook.save();
        Company twitter = new Company();
        twitter.name = "Twitter";
        twitter.save();

        Person joe = new Person();
        joe.name = "Joe";
        joe.save();

        joe.positions = new ArrayList<Position>();

        Position joeAtFacebook = new Position(facebook);
        joeAtFacebook.projects.add(new Project("Stream", "Architect"));
        joeAtFacebook.projects.add(new Project("Messages", "Lead QA"));
        joe.positions.add(joeAtFacebook);

        Position joeAtTwitter = new Position(twitter);
        joeAtTwitter.projects.add(new Project("Steal stuff from Facebook", "Chief Thief"));
        joe.save();
    }
}
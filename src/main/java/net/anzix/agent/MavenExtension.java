package net.anzix.agent;

import java.util.logging.Logger;

import org.apache.maven.AbstractMavenLifecycleParticipant;
import org.apache.maven.eventspy.EventSpy;
import org.apache.maven.eventspy.EventSpy.Context;
import org.apache.maven.eventspy.internal.EventSpyDispatcher;
import org.apache.maven.execution.MavenSession;
import org.apache.maven.execution.RuntimeInformation;
import org.codehaus.plexus.PlexusContainer;
import org.codehaus.plexus.component.annotations.Component;
import org.codehaus.plexus.component.annotations.Requirement;

@Component(role = AbstractMavenLifecycleParticipant.class, hint = "retro")
public class MavenExtension extends AbstractMavenLifecycleParticipant {

	public void afterProjectsRead(MavenSession session) {
		Timestamper.changeStreams();

	}

}
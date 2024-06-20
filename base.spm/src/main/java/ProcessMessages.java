import eapli.base.app.common.console.presentation.authz.LoginUI;
import eapli.base.clientusermanagement.application.eventhandlers.NewUserRegisteredFromSignupWatchDog;
import eapli.base.clientusermanagement.domain.events.NewUserRegisteredFromSignupEvent;
import eapli.base.clientusermanagement.domain.events.SignupAcceptedEvent;
import eapli.base.usermanagement.application.eventhandlers.SignupAcceptedWatchDog;
import presentation.MainMenu;
import presentation.ProcessMessageUI;
import eapli.base.app.common.console.BaseApplication;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.domain.BasePasswordPolicy;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.PlainTextEncoder;
import eapli.framework.infrastructure.eventpubsub.EventDispatcher;

public class ProcessMessages extends BaseApplication {

    public static void main(String[] args){
        AuthzRegistry.configure(PersistenceContext.repositories().users(),
                new BasePasswordPolicy(), new PlainTextEncoder());

        new ProcessMessages().run(args);
    }

    @Override
    protected void doMain(String[] args) {
        if (new LoginUI().show()) {
            // go to main menu
            final MainMenu menu = new MainMenu();
            menu.mainLoop();
        }
    }

    @Override
    protected String appTitle() {
        return "Process Messages";
    }

    @Override
    protected String appGoodbye() {
        return "See you!";
    }

    @Override
    protected void doSetupEventHandlers(EventDispatcher dispatcher) {
        dispatcher.subscribe(new NewUserRegisteredFromSignupWatchDog(),
                NewUserRegisteredFromSignupEvent.class);
        dispatcher.subscribe(new SignupAcceptedWatchDog(), SignupAcceptedEvent.class);
    }
}

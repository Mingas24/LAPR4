package eapli.base.errornotificationmanagement.domain;

public enum ErrorType {
    INEXISTENT_PRODUCT,
    INEXISTENT_PRODUCTION_LINE,
    INEXISTENT_PRODUCTION_ORDER,
    INEXISTENT_DEPOSIT,
    INEXISTENT_RAWMATERIAL,
    END_WITHOUT_BEGIN,
    RESUME_WITHOUT_STOP,
    STOP_NON_ACTIVE_MACHINE
}

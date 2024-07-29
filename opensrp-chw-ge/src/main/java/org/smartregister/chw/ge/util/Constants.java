package org.smartregister.chw.ge.util;

public interface Constants {

    int REQUEST_CODE_GET_JSON = 2244;
    String ENCOUNTER_TYPE = "encounter_type";
    String STEP_ONE = "step1";
    String STEP_TWO = "step2";

    interface JSON_FORM_EXTRA {
        String JSON = "json";

        String ENCOUNTER_TYPE = "encounter_type";

        String DELETE_EVENT_ID = "deleted_event_id";

        String DELETE_FORM_SUBMISSION_ID = "deleted_form_submission_id";
    }

    interface EVENT_TYPE {
        String GE_ENROLLMENT = "GE Enrollment";

        String GE_FOLLOW_UP_VISIT = "GE Follow-up Visit";

        String GE_MOBILIZATION = "GE Mobilization";

        String DELETE_EVENT = "Delete Event";
    }

    interface FORMS {
        String GE_ENROLLMENT = "ge_enrollment";

        String GE_MOBILIZATION_SESSION = "ge_mobilization";
    }

    interface TABLES {
        String GE_REGISTER = "ec_ge_register";

        String GE_FOLLOW_UP = "ec_ge_follow_up_visit";

        String GE_MOBILIZATION_SESSIONS = "ec_ge_mobilization_session";
    }

    interface ACTIVITY_PAYLOAD {
        String BASE_ENTITY_ID = "BASE_ENTITY_ID";
        String FAMILY_BASE_ENTITY_ID = "FAMILY_BASE_ENTITY_ID";
        String ACTION = "ACTION";
        String GE_FORM_NAME = "GE_FORM_NAME";
        String EDIT_MODE = "editMode";
        String MEMBER_PROFILE_OBJECT = "MemberObject";

    }

    interface ACTIVITY_PAYLOAD_TYPE {
        String REGISTRATION = "REGISTRATION";

        String FOLLOW_UP_VISIT = "FOLLOW_UP_VISIT";
    }

    interface CONFIGURATION {
        String GE_REGISTRATION_CONFIGURATION = "ge_registration";
    }

}
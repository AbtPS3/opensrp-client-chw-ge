package org.smartregister.chw.ge_sample.interactor;

import org.smartregister.chw.ge.domain.MemberObject;
import org.smartregister.chw.ge.interactor.BaseGeVisitInteractor;
import org.smartregister.chw.ge_sample.activity.EntryActivity;

public class GeVisitInteractor extends BaseGeVisitInteractor {
    @Override
    public MemberObject getMemberClient(String memberID) {
        return EntryActivity.getSampleMember();
    }
}

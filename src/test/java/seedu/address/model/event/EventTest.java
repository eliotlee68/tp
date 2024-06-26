package seedu.address.model.event;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.VALID_CLIENT_NAME_HOUSE_CHECKUP_BENSON;
import static seedu.address.logic.commands.CommandTestUtil.VALID_DESCRIPTION_HOUSE_CHECKUP_BENSON;
import static seedu.address.logic.commands.CommandTestUtil.VALID_HEADING_HOUSE_CHECKUP_BENSON;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TIME_HOUSE_CHECKUP_BENSON;
import static seedu.address.testutil.TypicalEvents.HOUSE_CHECKUP_BENSON;
import static seedu.address.testutil.TypicalEvents.MEETING_WITH_ALICE;

import org.junit.jupiter.api.Test;

import seedu.address.testutil.EventBuilder;

public class EventTest {
    @Test
    public void isSameEvent() {
        // same object -> returns true
        assertTrue(MEETING_WITH_ALICE.isSameEvent(MEETING_WITH_ALICE));

        // null -> returns false
        assertFalse(MEETING_WITH_ALICE.isSameEvent(null));

        // same heading -> returns true
        Event eventWithSameHeading = new EventBuilder().withHeading(MEETING_WITH_ALICE.getHeadingString()).build();
        assertTrue(MEETING_WITH_ALICE.isSameEvent(eventWithSameHeading));
    }

    @Test
    public void equals() {
        // same values -> returns true
        Event meetingWithAliceCopy = new EventBuilder().build();
        assertTrue(MEETING_WITH_ALICE.equals(meetingWithAliceCopy));
        // same object -> returns true
        assertTrue(MEETING_WITH_ALICE.equals(MEETING_WITH_ALICE));
        // null -> returns false
        assertFalse(MEETING_WITH_ALICE.equals(null));
        // different type -> returns false
        assertFalse(MEETING_WITH_ALICE.equals(5));
        // different event -> returns false
        assertFalse(MEETING_WITH_ALICE.equals(HOUSE_CHECKUP_BENSON));

        // different title -> returns false
        Event updatedAlice = new EventBuilder(MEETING_WITH_ALICE)
                .withHeading(VALID_HEADING_HOUSE_CHECKUP_BENSON).build();
        assertFalse(MEETING_WITH_ALICE.equals(updatedAlice));

        // different time -> returns false
        updatedAlice = new EventBuilder(MEETING_WITH_ALICE).withLocalDateTime(VALID_TIME_HOUSE_CHECKUP_BENSON).build();
        assertFalse(MEETING_WITH_ALICE.equals(updatedAlice));

        // different client name -> returns false
        updatedAlice = new EventBuilder(MEETING_WITH_ALICE)
                .withClientName(VALID_CLIENT_NAME_HOUSE_CHECKUP_BENSON).build();
        assertFalse(MEETING_WITH_ALICE.equals(updatedAlice));

        // different description -> returns false
        updatedAlice = new EventBuilder(MEETING_WITH_ALICE)
                .withDescription(VALID_DESCRIPTION_HOUSE_CHECKUP_BENSON).build();
        assertFalse(MEETING_WITH_ALICE.equals(updatedAlice));
    }

    @Test
    public void toStringMethod() {
        String expected = Event.class.getCanonicalName() + "{name=" + MEETING_WITH_ALICE.getClientName()
                + ", heading=" + MEETING_WITH_ALICE.getHeading()
                + ", description=" + MEETING_WITH_ALICE.getDescription()
                + ", time=" + MEETING_WITH_ALICE.getTime() + "}";
        assertEquals(expected, MEETING_WITH_ALICE.toString());
    }

    @Test
    public void hashCode_differentValues_differentHashCode() {
        Event event1 = new EventBuilder().build();
        Event event2 = new EventBuilder().withHeading("Different Heading").build();
        assertNotEquals(event1.hashCode(), event2.hashCode());
    }

}

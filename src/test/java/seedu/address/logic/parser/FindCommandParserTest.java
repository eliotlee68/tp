package seedu.address.logic.parser;
import seedu.address.logic.parser.exceptions.ParseException;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.FindCommand;

public class FindCommandParserTest {

    private FindCommandParser parser = new FindCommandParser();

    @Test
    public void parse_emptyArg_throwsParseException() {
        assertParseFailure(parser, "     ", String.format(MESSAGE_INVALID_COMMAND_FORMAT, FindCommand.MESSAGE_USAGE));
    }

    @Test
    public void parse_prefixEmptyArg_throwsParseException() {
        assertParseFailure(parser, " n/", String.format(
            MESSAGE_INVALID_COMMAND_FORMAT, FindCommand.MESSAGE_USAGE));
    }

    @Test
    public void parse_emptyArgWithPrefix_throwsParseException() {
        assertParseFailure(parser, " n/ a/ k/", String.format(
            MESSAGE_INVALID_COMMAND_FORMAT, FindCommand.MESSAGE_USAGE));
    }

    @Test
    public void parse_argNoPrefix_throwsParseException() {
        assertParseFailure(parser, "alex", String.format(
            MESSAGE_INVALID_COMMAND_FORMAT, FindCommand.MESSAGE_USAGE));
    }

    @Test
    public void parse_expectedCommand_success() throws ParseException {
        assertParseSuccess(parser, "n/alex yeoh a/clementi #40",
            parser.parse(" n/alex yeoh a/clementi #40"));
    }
}

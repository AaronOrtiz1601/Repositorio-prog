import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({ AprobarTest.class })
@IncludeTags("version1")
public class SuiteAProbar {

}

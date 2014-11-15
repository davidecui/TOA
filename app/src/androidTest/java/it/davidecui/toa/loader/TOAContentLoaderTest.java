package it.davidecui.toa.loader;

import it.davidecui.toa.model.TOAContent;
import it.davidecui.toa.testutil.SupportLoaderTestCase;

public class TOAContentLoaderTest extends SupportLoaderTestCase {

    public void testGetTOAContent() {
        TOAContentLoader mTarget = new TOAContentLoader(getContext());
        TOAContent result = getLoaderResultSynchronously(mTarget);
        assertNotNull(result);
        assertTrue(result.getItems().size() > 0);
    }
}
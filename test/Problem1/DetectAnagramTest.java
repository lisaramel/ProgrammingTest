package Problem1;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Lisa Ramel
 * Date: 2021-04-14
 * Time: 14:16
 * Project: ProgrammingTest
 * Copywrite: MIT
 */
public class DetectAnagramTest {

    DetectAnagram da = new DetectAnagram();

    @Test
    public final void isAnAnagram(){
        assertTrue(da.findAnagram("snick", "nicks"));
        assertTrue(da.findAnagram("snIcK", "Nicks"));
        assertTrue(da.findAnagram("snooze alarms", "alas no more zs "));
    }

    @Test
    public final void notAnAnagram(){
        assertFalse(da.findAnagram("snick", "snack"));
        assertFalse(da.findAnagram("snick", "snicks"));
    }
}

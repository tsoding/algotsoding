package me.rexim.algotsoding;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SippyMixerTest {
    @Test
    public void drinkTea() throws Exception {
        Mixer mixer = new SippyMixer();

        assertEquals(42, mixer.drinkTea(42));
    }
}
package com.ibm.cz.csob.thub;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Sequence number for T-HUB calls from node
 * 
 * This sequence is used for generation of call sequence for SessionId in T-HUB metaheader. 
 * <b>After node or application is restarted, the sequence is restarted (starts from 1)</b>, 
 * but other components of the SessionId should help to generate unique ID.   
 * 
 * @author Jiri Melichna
 *
 */
public class THUBCallSequence {
	
    private AtomicLong callIdGenerator = null;

	private static class SequenceHolder {
        public static final THUBCallSequence instance = new THUBCallSequence();
    }

    public static THUBCallSequence getInstance() {
        return SequenceHolder.instance;
    }
    
    private THUBCallSequence() {
    	callIdGenerator = new AtomicLong();
    }

    private AtomicLong getGenerator() {
        return callIdGenerator;
    }

    /**
     * This operation returns next ID from the sequence.
     *  
     * @return New call id for SessionId
     */
    public long getNewCallId(){
        return getGenerator().incrementAndGet();
    }
}

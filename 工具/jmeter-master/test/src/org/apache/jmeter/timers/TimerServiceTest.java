/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package org.apache.jmeter.timers;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class TimerServiceTest {

    TimerService sut = TimerService.getInstance();

    @Test
    public void testBigInitialDelay() {
        long now = System.currentTimeMillis();
        long adjustedDelay = sut.adjustDelay(Long.MAX_VALUE, now + 1000L);
        Assert.assertThat("TimerService should return -1 as delay would lead to a time after end time",
                Long.valueOf(adjustedDelay), CoreMatchers.is(Long.valueOf(-1)));
    }

    @Test
    public void testSmallInitialDelay() {
        long now = System.currentTimeMillis();
        Assert.assertThat("TimerService should not change the delay as the end time is far away",
                Long.valueOf(sut.adjustDelay(1000L, now + 20000L)), CoreMatchers.is(Long.valueOf(1000L)));
    }

    @Test
    public void testNegativeEndTime() {
        Assert.assertThat("TimerService should not change the delay as the indicated end time is far away",
                Long.valueOf(sut.adjustDelay(1000L, -1)), CoreMatchers.is(Long.valueOf(1000L)));
    }

}

// Copyright 2019 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.sps;

import java.util.Collection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import com.google.sps.TimeRange;
public final class FindMeetingQuery {
  public Collection<TimeRange> query(Collection<Event> events, MeetingRequest request) {
    //throw new UnsupportedOperationException("TODO: Implement this method.");
    Collection<String> attendees = request.getAttendees();
    ArrayList<TimeRange> stuckTime = new ArrayList<>();


    for (Event curr : events) {
        int flag = 0;// in meeting or not
        Set<String> eventAttendees = curr.getAttendees();
        for (String attendee : attendees) {
            if (eventAttendees.contains(attendee)) {
                flag = 1;
                break;
            }
        }
        if (flag==0) {
        continue;
      }
      stuckTime.add(curr.getWhen());
    }
    
    stuckTime.sort(TimeRange.ORDER_BY_START);
    ArrayList<TimeRange> noOverlap = new ArrayList<>();

    int rec = 0;
    for (TimeRange curr : stuckTime) {
    
        if (curr.end() <= rec) {
        continue;
        }
      
        if (curr.start() < rec) {
            rec = curr.end();
            continue;
        }
      
        if (curr.start() - rec >= request.getDuration()) {
            noOverlap.add(TimeRange.fromStartEnd(rec, curr.start(), false));
        } 
        rec = curr.end();
    }
    
    if (TimeRange.WHOLE_DAY.end()- rec >= request.getDuration()) {
      noOverlap.add(TimeRange.fromStartEnd(rec, TimeRange.WHOLE_DAY.end(), false));
    }
    return noOverlap;
  }
}

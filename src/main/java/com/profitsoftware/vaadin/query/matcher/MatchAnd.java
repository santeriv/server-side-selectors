/*
 * Copyright 2013 Profit Software Oy
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.profitsoftware.vaadin.query.matcher;

import org.apache.commons.lang3.StringUtils;

import com.profitsoftware.vaadin.query.Matcher;
import com.vaadin.ui.Component;

public class MatchAnd implements Matcher {

  private static final long serialVersionUID = 1L;

  private Matcher[] matchers;

  public MatchAnd(Matcher... matcher) {
    this.matchers = matcher;
  }

  public boolean match(Component component) {
    for (Matcher m : matchers) {
      if (!m.match(component)) {
        return false;
      }
    }
    return true;
  }

  @Override
  public String toString() {
   return "and(" + StringUtils.join(matchers, ",") + ")";
  }

}

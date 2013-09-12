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

import com.profitsoftware.vaadin.query.Matcher;
import com.vaadin.ui.Component;

public class MatchAncestor implements Matcher {

  private static final long serialVersionUID = 1L;

  public Matcher matcher;

  public MatchAncestor(Matcher matcher) {
    this.matcher = matcher;
  }

  public boolean match(Component component) {
    Component c = component.getParent();
    if (c == null) {
      return false;
    }
    do {
      if (matcher.match(c)) {
        return true;
      }
      c = c.getParent();
    } while(c != null);
    return false;
  }

  @Override
  public String toString() {
    return "ancestor(" + matcher + ")";
  }
}

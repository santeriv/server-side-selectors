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

public class MatchNot implements Matcher {

  private static final long serialVersionUID = 2091118798748651273L;

  private final Matcher matcher;

  public MatchNot(final Matcher matcher) {
    if (matcher == null) {
      throw new IllegalArgumentException("matcher may not be null");
    }
    this.matcher = matcher;
  }

  public boolean match(Component component) {
    return !matcher.match(component);
  }

  @Override
  public String toString() {
    return "not(" + matcher + ")";
  }

  public static boolean isMatchAll(Matcher matcher) {
    return matcher instanceof MatchAny;
  }

  public Matcher getMatcher() {
    return matcher;
  }

}

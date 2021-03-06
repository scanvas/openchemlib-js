/*

Copyright (c) 2015-2017, cheminfo

All rights reserved.

Redistribution and use in source and binary forms, with or without modification,
are permitted provided that the following conditions are met:

    * Redistributions of source code must retain the above copyright notice,
      this list of conditions and the following disclaimer.
    * Redistributions in binary form must reproduce the above copyright notice,
      this list of conditions and the following disclaimer in the documentation
      and/or other materials provided with the distribution.
    * Neither the name of {{ project }} nor the names of its contributors
      may be used to endorse or promote products derived from this software
      without specific prior written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
"AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR
CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.

*/

package com.actelion.research.gwt.gui.editor;

import com.actelion.research.share.gui.editor.io.IKeyCode;
import com.google.gwt.event.dom.client.KeyCodes;

public class ACTKeyCode implements IKeyCode {
  public static final ACTKeyCode DELETE = new ACTKeyCode(KeyCodes.KEY_DELETE, "Delete", 0);
  public static final ACTKeyCode ESCAPE = new ACTKeyCode(KeyCodes.KEY_ESCAPE, "Escape", 0);
  public static final ACTKeyCode BACK_SPACE = new ACTKeyCode(KeyCodes.KEY_BACKSPACE, "Escape", 0);
  public static final ACTKeyCode ENTER = new ACTKeyCode(KeyCodes.KEY_ENTER, "Escape", 0);

  final int code;
  final String ch;
  final String name;
  private int mask;

  // Need to bundle this in another class to avoid "forward reference" compiler
  // error
  private static class KeyCodeClass {
    private KeyCodeClass() {
    };

    private static final int FUNCTION = 1;
    private static final int NAVIGATION = 1 << 1;
    private static final int ARROW = 1 << 2;
    private static final int MODIFIER = 1 << 3;
    private static final int LETTER = 1 << 4;
    private static final int DIGIT = 1 << 5;
    private static final int KEYPAD = 1 << 6;
    private static final int WHITESPACE = 1 << 7;
    private static final int MEDIA = 1 << 8;
  }

  public ACTKeyCode(int code, String name, int mask) {
    this.code = code;
    this.name = name;
    this.mask = mask;
    ch = String.valueOf((char) code);
  }

  /**
   * Function keys like F1, F2, etc...
   * 
   * @return true if this key code corresponds to a functional key
   * @since 2.2
   */
  public final boolean isFunctionKey() {
    return (mask & KeyCodeClass.FUNCTION) != 0;
  }

  /**
   * Navigation keys are arrow keys and Page Down, Page Up, Home, End (including
   * keypad keys)
   * 
   * @return true if this key code corresponds to a navigation key
   * @since 2.2
   */
  public final boolean isNavigationKey() {
    return (mask & KeyCodeClass.NAVIGATION) != 0;
  }

  /**
   * Left, right, up, down keys (including the keypad arrows)
   * 
   * @return true if this key code corresponds to an arrow key
   * @since 2.2
   */
  public final boolean isArrowKey() {
    return (mask & KeyCodeClass.ARROW) != 0;
  }

  /**
   * Keys that could act as a modifier
   * 
   * @return true if this key code corresponds to a modifier key
   * @since 2.2
   */
  public final boolean isModifierKey() {
    return (mask & KeyCodeClass.MODIFIER) != 0;
  }

  /**
   * All keys with letters
   * 
   * @return true if this key code corresponds to a letter key
   * @since 2.2
   */
  public final boolean isLetterKey() {
    return (mask & KeyCodeClass.LETTER) != 0;
  }

  /**
   * All Digit keys (including the keypad digits)
   * 
   * @return true if this key code corresponds to a digit key
   * @since 2.2
   */
  public final boolean isDigitKey() {
    return (mask & KeyCodeClass.DIGIT) != 0;
  }

  /**
   * All keys on the keypad
   * 
   * @return true if this key code corresponds to a keypad key
   * @since 2.2
   */
  public final boolean isKeypadKey() {
    return (mask & KeyCodeClass.KEYPAD) != 0;
  }

  /**
   * Space, tab and enter
   * 
   * @return true if this key code corresponds to a whitespace key
   * @since 2.2
   */
  public final boolean isWhitespaceKey() {
    return (mask & KeyCodeClass.WHITESPACE) != 0;
  }

  /**
   * All multimedia keys (channel up/down, volume control, etc...)
   * 
   * @return true if this key code corresponds to a media key
   * @since 2.2
   */
  public final boolean isMediaKey() {
    return (mask & KeyCodeClass.MEDIA) != 0;
  }

  /**
   * Gets name of this key code.
   * 
   * @return Name of this key code
   */
  public final String getName() {
    return name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    ACTKeyCode keyCode = (ACTKeyCode) o;

    if (code != keyCode.code) {
      return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return code;
  }
}

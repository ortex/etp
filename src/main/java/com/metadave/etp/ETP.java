/*
 * -------------------------------------------------------------------
 *
 *   Copyright (c) 2013 Dave Parfitt
 *
 *   This file is provided to you under the Apache License,
 *   Version 2.0 (the "License"); you may not use this file
 *   except in compliance with the License.  You may obtain
 *   a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing,
 *   software distributed under the License is distributed on an
 *   "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *   KIND, either express or implied.  See the License for the
 *   specific language governing permissions and limitations
 *   under the License.
 * -------------------------------------------------------------------
 */

package com.metadave.etp;


import com.metadave.etp.rep.ETPTerm;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.InputStream;

public class ETP {
    public static ETPTerm parse(String s) {
        ANTLRInputStream input = new ANTLRInputStream(s);
        ETPLexer lexer = new ETPLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ETPParser parser = new ETPParser(tokens);
        ETPWalker ew = new ETPWalker();
        ParseTreeWalker walker = new ParseTreeWalker();
        ETPTerm<?> term = null;
        ETPParser.Etp_termContext t = parser.etp_term();
        walker.walk(ew, t);
        term = (ETPTerm<?>)ew.getValue(t);
        return term;
    }

    public static ETPTerm parse(InputStream is) throws Exception {
        ANTLRInputStream input = new ANTLRInputStream(is);
        ETPLexer lexer = new ETPLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ETPParser parser = new ETPParser(tokens);
        ETPWalker ew = new ETPWalker();
        ParseTreeWalker walker = new ParseTreeWalker();
        ETPTerm<?> term = null;
        ETPParser.Etp_termContext t = parser.etp_term();
        walker.walk(ew, t);
        term = (ETPTerm<?>)ew.getValue(t);
        return term;
    }
}

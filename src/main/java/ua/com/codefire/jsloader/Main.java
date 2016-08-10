/*
 * Copyright (C) 2016 CodeFireUA <edu@codefire.com.ua>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package ua.com.codefire.jsloader;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.script.CompiledScript;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import jdk.nashorn.api.scripting.NashornScriptEngine;

/**
 *
 * @author CodeFireUA <edu@codefire.com.ua>
 */
public class Main {

    public static void main(String[] args) {

        ScriptEngineManager engineManager = new ScriptEngineManager();
        NashornScriptEngine scriptEngine = (NashornScriptEngine) engineManager.getEngineByExtension("js");
        
        File modules = new File("./modules/");
        
        File[] listFiles = modules.listFiles();
        if (listFiles != null) {
            for (File listFile : listFiles) {
                try (FileReader reader = new FileReader(listFile)) {
                    scriptEngine.eval(reader);
                    App app = (App) scriptEngine.get("app");
                    
                    System.out.println(app);

                    scriptEngine.invokeFunction(app.getMain());
                } catch (ScriptException | IOException | NoSuchMethodException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }
}

import java.io.*;
import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Solution {

    private static class El implements Comparable<El>{
        final HashSet<String> attrs;
        final String name;
        El(String name) {
            this.name = name;
            attrs = new HashSet<>();
        }

        @Override
        public boolean equals(Object that) {
            if(! (that instanceof El)) return false;
            return this.name.equals(((El)that).name);
        }

        @Override
        public int compareTo(El that) {
            return this.name.compareTo(that.name);
        }
    }

    final static HashMap<String, El> els = new HashMap<>();

    public static void main(String[] args) {
        try (
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))
        ) {

            int n = Integer.parseInt(bf.readLine().trim());
            Pattern p = Pattern.compile("\\<([^\\s\\/]+)\\s*?(.*)\\>");
            Pattern attRE = Pattern.compile("\\s+?([^=]+?)=[\"'].*?[\"']");
            String elName, attrName, line, elLine, attrLine;
            Matcher m, at;
            int elStartIndx, elEndIndx;
            while(n-- > 0) {
                line = bf.readLine();
                elEndIndx = 0;

                while(true) {
                    elStartIndx = line.indexOf('<', elEndIndx);
                    elEndIndx = line.indexOf('>', elStartIndx);

                    if(elStartIndx == -1) break;

                    elLine = line.substring(elStartIndx, elEndIndx+1);
                    m = p.matcher(elLine);
                    if(m.matches()) {
                        elName = m.group(1);
                        El newEl = els.get(elName);
                        if(newEl == null) {
                            newEl = new El(elName);
                            els.put(elName, newEl);
                        }

                        attrLine = m.group(2);
                        at = attRE.matcher(attrLine);
                        while(at.find()) {
                            attrName = at.group(1);
                            newEl.attrs.add(attrName);
                        }
                    }
                }
            }

            ArrayList<El> elsArr = new ArrayList<>();
            for(El e : els.values())
                elsArr.add(e);

            Collections.sort(elsArr);

            ArrayList<String> attrs = new ArrayList<>();
            StringBuilder outline = new StringBuilder();
            for(El e : elsArr) {
                attrs.addAll(e.attrs);

                Collections.sort(attrs);

                outline.append(e.name).append(":");
                for(String attr : attrs)
                    outline.append(attr).append(",");
                if(outline.charAt(outline.length()-1) == ',')
                    outline.deleteCharAt(outline.length()-1);
                System.out.println(outline.toString());

                outline.setLength(0);
                attrs.clear();
            }

        } catch(IOException e) {}
    }
}

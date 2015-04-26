map = {
   "\\u000D" => "\n",
   "\\u000A" => "",
   "\\u003B" => ";",
   "\\u003C" => "<",
   "\\u003E" => ">",
   "\\u003D" => "=",
   "\\u0026" => "&",
   "\\u002D" => "-",
   "\\u0022" => "\"",
   "\\u0009" => "\t",
   "\\u0027" => "'",
   "\\u005C" => "\\"
}

File.open("result.txt").each_line do |line|
  next if line.strip.empty?
  array = line.split("=>")
  base_title = array.first.split(" ").join("_").strip
  program = array.last.split("=")
  suffix = program.first.split(".").last.strip
  code = program.last
  map.each{|key,value| code.gsub!(key,value)}
  code = code.strip.chomp(";").chomp("'").reverse.chomp("'").reverse
  unless File.exist? "LeetCode/"+base_title+"."+suffix
    ans = open("LeetCode/"+base_title+"."+suffix,"w")
    ans.write(code)
    ans.close
  else
    version = 1
    while File.exist? "LeetCode/"+base_title+version.to_s+"."+suffix
      version += 1
    end
    ans = open("LeetCode/"+base_title+version.to_s+"."+suffix,"w")
    ans.write(code)
    ans.close
  end
end

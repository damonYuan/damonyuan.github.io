class BracketsCombinations

  def initialize(i=0) 
    @pairs = i
  end

  def brackets(pairs, output='', open=0, close=0, arr=[]) 
    arr << output if open == pairs && close == pairs
    brackets pairs, output + '(', open + 1, close, arr if open < pairs
    brackets pairs, output + ')', open, close + 1, arr if close < open
    arr
  end

  def show 
    p brackets(3)
  end
end

bc = BracketsCombinations.new(3)
bc.show

    


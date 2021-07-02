DisjointSet = Class.new do
    class Node 
        attr_accessor :data
        attr_accessor :parent
        attr_accessor :rank
    end
    
    attr_accessor :map

    def initialize
        @map = []
    end

    def make_set(data) 
        node = DisjointSet::Node.new
        node.data = data
        node.parent = node
        node.rank = 0
        @map[data] = node
    end

    def union(data1, data2)
        node1 = map[data1]
        node2 = map[data2]

        parent1 = find_parent node1
        parent2 = find_parent node2

        if parent1.data == parent2.data
            return false
        end

        if parent1.rank >= parent2.rank
            parent1.rank = parent1.rank == parent2.rank ? parent1.rank + 1 : parent1.rank
            parent2.parent = parent1
        elsif
            parent1.parent = parent2
        end
        
        return true
    end

    def find_set(data)
        return find_parent(@map[data]).data
    end

    def find_parent(node)
        parent = node.parent
        if parent == node
            return parent
        end

        node.parent = find_parent(node.parent)
        return node.parent
    end

end

def main
    ds = DisjointSet.new
    ds.make_set 1
    ds.make_set 2
    ds.make_set 3
    ds.make_set 4
    ds.make_set 5
    ds.make_set 6
    ds.make_set 7

    ds.union 1, 2
    ds.union 2, 3
    ds.union 4, 5
    ds.union 6, 7
    ds.union 5, 6
    ds.union 3, 7

    puts ds.find_set(3)
    puts ds.find_set(4)
    puts ds.find_set(5)
    puts ds.find_set(6)
    puts ds.find_set(7)
end

main


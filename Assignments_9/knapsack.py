

def knapsack(items,bag_size):
    # knapsack algorithm
    # opt(i,w) = 0  if i==0
    #          = opt(i-1,w) if wi > w
    #          = max{ opt(i-1,w) , vi + opt(i-1,w-wi) } otherwise



if __name__ == '__main__':
    items = []
    with open("data10_knapsack.txt","r",encoding='utf-8') as f:
        for line in f:
            item = line.strip().split(",")
            item_value = item[1]
            item_weight = item[2]
            items.append([item_value, item_weight])
    # print(items)

    bag_size = input("input bag_size ( 0-50 ) : ")
    knapsack(items,bag_size)

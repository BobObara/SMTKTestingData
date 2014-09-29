<?xml version="1.0" encoding="utf-8" ?>
<!-- Generated by jade. See john for source file-->
<!--
Covers many of the attribute features:
Types: double, group, integer, string, void
Options: AdvanceLevel, Abstract, Associations, Discrete, Extensible,
  Optional, Label, NumberOfRequiredValues, Unique, Units, Version
Also: expression, inheritance, RangeInfo, DefaultValue
STILL MISSING/TODO:
  Categories
  Conditional children items
  Extensible group
  
-->
<SMTK_AttributeSystem Version="2">
  <Definitions>
    <AttDef Type="CommonBase" Abstract="true" Associations="v">
      <ItemDefinitions>
        <Double Name="CommonDouble" Label="Floating Pt Val">
          <RangeInfo>
            <Min Inclusive="false">0.0</Min>
            <Max Inclusive="true">1.0</Max>
          </RangeInfo>
          <DefaultValue>3.14159</DefaultValue>
        </Double>
      </ItemDefinitions>
    </AttDef>
    <AttDef Type="FirstConcrete" BaseType="CommonBase" Units="Decibels">
      <ItemDefinitions>
        <Int Name="AdvancedInt" AdvanceLevel="1" Version="73">
          <BriefDescription>This is a brief description field.</BriefDescription>
        </Int>
        <String Name="OptionalStrings" Optional="true" NumberOfRequiredValues="2">
          <ComponentLabels>
            <Label>1st</Label>
            <Label>2nd</Label>
          </ComponentLabels>
          <DetailedDescription>This is a "detailed" description.</DetailedDescription>
        </String>
        <Void Name="Checkbox"></Void>
      </ItemDefinitions>
    </AttDef>
    <AttDef Type="PolyLinearFunction" Unique="true">
      <ItemDefinitions>
        <Group Name="ValuePairs">
          <ItemDefinitions>
            <Double Name="X" NumberOfRequiredValues="0" Extensible="true"></Double>
            <Double Name="Y" NumberOfRequiredValues="0" Extensible="true"></Double>
          </ItemDefinitions>
        </Group>
        <String Name="NameOfExpression"></String>
      </ItemDefinitions>
    </AttDef>
    <AttDef Type="AnotherAbstractBase" BaseType="CommonBase" Abstract="true" Version="42">
      <ItemDefinitions>
        <Double Name="DoubleExpression">
          <ExpressionType>PolyLinearFunction</ExpressionType>
        </Double>
      </ItemDefinitions>
    </AttDef>
    <AttDef Type="SecondConcrete" BaseType="AnotherAbstractBase" Unique="true">
      <ItemDefinitions>
        <Int Name="SelectionList">
          <DiscreteInfo DefaultIndex="2">
            <Value Enum="Choice A">0</Value>
            <Value Enum="Choice B">1</Value>
            <Value Enum="Choice C">2</Value>
          </DiscreteInfo>
        </Int>
        <AttributeRef Name="Reference" Label="AttributeRef (FirstConcrete)" NumberOfRequiredValues="1">
          <AttDef>FirstConcrete</AttDef>
        </AttributeRef>
        <ModelEntity Name="ModelFace" NumberOfRequiredValues="1">
          <!-- Model face is 0x104 == 404 decimal-->
          <MembershipMask>404</MembershipMask>
        </ModelEntity>
        <String Name="ConditionalSelectionList">
          <ChildrenDefinitions>
            <Double Name="FirstDouble" Label="First Double">
              <DefaultValue>1.1</DefaultValue>
            </Double>
            <Double Name="SecondDouble" Label="Second Double">
              <ExpressionType>PolyLinearFunction</ExpressionType>
            </Double>
            <AttributeRef Name="Reference" Label="Ref to FirstConcrete" NumberOfRequiredValues="1">
              <AttDef>FirstConcrete</AttDef>
            </AttributeRef>
          </ChildrenDefinitions>
          <DiscreteInfo DefaultIndex="1">
            <Structure>
              <Value Enum="One">0</Value>
              <Items>
                <Item>FirstDouble</Item>
              </Items>
            </Structure>
            <Structure>
              <Value Enum="Two">1</Value>
              <Items>
                <Item>FirstDouble</Item>
                <Item>SecondDouble</Item>
                <Item>Reference</Item>
              </Items>
            </Structure>
          </DiscreteInfo>
        </String>
      </ItemDefinitions>
    </AttDef>
  </Definitions>
</SMTK_AttributeSystem>
